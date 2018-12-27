package com.example.springdatajpasample.manytoone.uni;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class PhoneManyToOneUniPredicate {
	public static Predicate search(String number) {
		QPhoneManyToOneUni phone = QPhoneManyToOneUni.phoneManyToOneUni;
		QPersonManyToOneUni person = QPersonManyToOneUni.personManyToOneUni;
		
		BooleanBuilder builder = new BooleanBuilder();
		if(number != null) {
			builder.and(phone.number.eq(number));
		}
//		if(lastName != null) {
//			builder.and(phone.person.lastName.like("%" + lastName +"%"));
//		}
//		builder.and(phone.person.id.eq(person.id));
		
		return builder;
	}
}
