package com.nickmcgough.fetchrewardschallenge.utils

import com.nickmcgough.fetchrewardschallenge.datamodels.ListItem

fun sortItemListByListId(list: List<ListItem>): List<ListItem>{
    return list.sortedBy { it.listId }
}

fun sortItemListByName(list: List<ListItem>): List<ListItem>{
    return list.sortedBy { it.name }
}

fun sortItemListByNameThenListId(list: List<ListItem>): List<ListItem>{
    return sortItemListByListId(sortItemListByName( list))
}