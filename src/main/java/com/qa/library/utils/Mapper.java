package com.qa.library.utils;

public interface Mapper<E, D> {

	D mapToDTO(E entity);

	E mapFromDTO(D dto);
}