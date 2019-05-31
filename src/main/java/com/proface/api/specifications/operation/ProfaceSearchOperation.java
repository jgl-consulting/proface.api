package com.proface.api.specifications.operation;

public enum ProfaceSearchOperation {

	EQUALITY, NEGATION, GREATER_THAN, LESS_THAN, GREATER_EQUAL_THAN, LESS_EQUAL_THAN, LIKE, STARTS_WITH, ENDS_WITH, CONTAINS;

	public static final String[] SIMPLE_OPERATION_SET = { ":", "!", ">", "<", "~" };

	public static ProfaceSearchOperation getSimpleOperation(char input) {
		switch (input) {
		case ':':
			return EQUALITY;
		case '!':
			return NEGATION;
		case '>':
			return GREATER_THAN;
		case '<':
			return LESS_THAN;
		case '~':
			return LIKE;
		default:
			return null;
		}
	}
}
