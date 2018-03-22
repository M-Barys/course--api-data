package com.example.topic.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.core.convert.converter.Converter;

public abstract class AbstractMapConverter<S, T> implements Converter<S, T> {
    private final TypeMap<S, T> typeMap;

    public AbstractMapConverter(Class<S> sourceT, Class<T> targetT) {
        ModelMapper modelMapper = new ModelMapper();
        typeMap = modelMapper.createTypeMap(sourceT, targetT);
    }

    @Override
    public T convert(S source) {
        return typeMap.map(source);
    }
}
