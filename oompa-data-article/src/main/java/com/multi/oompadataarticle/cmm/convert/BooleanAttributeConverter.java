package com.multi.oompadataarticle.cmm.convert;

import jakarta.persistence.AttributeConverter;

public class BooleanAttributeConverter implements AttributeConverter<Boolean, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Boolean attribute) {
        if (attribute) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Boolean convertToEntityAttribute(Integer data) {
        return data != 0;
    }
}
