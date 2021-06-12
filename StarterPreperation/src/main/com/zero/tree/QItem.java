package com.zero.tree;

public class QItem {
	BTNode node;
	int leftRightIndicator;
	QItem(BTNode curNode, int indicator){
		node = curNode;
		leftRightIndicator = indicator;
	}
}
