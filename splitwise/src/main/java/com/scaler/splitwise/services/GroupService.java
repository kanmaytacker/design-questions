package com.scaler.splitwise.services;

import com.scaler.splitwise.dtos.CreateExpenseDto;
import com.scaler.splitwise.dtos.CreateGroupDto;
import com.scaler.splitwise.models.*;
import com.scaler.splitwise.repositories.GroupExpenseRepository;
import com.scaler.splitwise.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class GroupService {

    private GroupRepository repository;
    private GroupExpenseRepository groupExpenseRepository;
    private UserService userService;
    private ExpenseService expenseService;

    private SettlementService settlementService;

    private static Set<Long> collateUserIds(CreateGroupDto request) {
        return Stream.of(request.getAdmins(), request.getMembers())
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public Group createGroup(CreateGroupDto request) {
        Set<Long> userIds = collateUserIds(request);

        List<User> users = userService.getUsers(userIds);
        Map<Long, User> idToUsers = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));

        Group group = buildGroup(request, idToUsers);
        return repository.save(group);
    }

    private Group buildGroup(CreateGroupDto request, Map<Long, User> idToUsers) {
        Group group = new Group();
        group.setName(request.getName());
        group.setCreatedBy(idToUsers.get(request.getCreatedBy()));
        group.setAdmins(request.getAdmins().stream().map(idToUsers::get).collect(Collectors.toList()));
        group.setMembers(request.getMembers().stream().map(idToUsers::get).collect(Collectors.toList()));
        return group;
    }

    public Group getGroup(Long groupId) {
        return repository.findById(groupId).orElseThrow(() -> new RuntimeException("Group not present!"));
    }

    public GroupExpense createGroupExpense(Long id, CreateExpenseDto request) {
        Group group = getGroup(id);
        Expense expense = expenseService.createExpense(request);

        GroupExpense groupExpense = new GroupExpense(group, expense);
        return groupExpenseRepository.save(groupExpense);
    }

    public List<SettleUpTransaction> settle(Long groupId) {
        List<Expense> expenses = getExpenses(groupId).stream()
                .map(GroupExpense::getExpense)
                .collect(Collectors.toList());
        return settlementService.settle(expenses);
    }

    public List<GroupExpense> getExpenses(Long groupId) {
        return groupExpenseRepository.findGroupExpensesByGroup_Id(groupId);
    }
}
