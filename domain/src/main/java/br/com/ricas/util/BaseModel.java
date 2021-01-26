package br.com.ricas.util;

import br.com.ricas.exceptions.FieldException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@Data
public abstract class BaseModel<T> {

    public void validateProperties(T clazz) {
        log.info("Initializing " + clazz.getClass().getName() + " validations");
        final String className = clazz.getClass().getName().substring(clazz.getClass().getName().lastIndexOf(".") + 1);
        Arrays.stream(clazz.getClass().getDeclaredFields()).forEach(field -> {
            try {
                field.setAccessible(true);
                if (field.getName().equals("UUID")) {
                    if (field.get(clazz) != null) {
                        if (!((String) field.get(clazz)).isEmpty() && (!CheckUUID.isValidUUID(field.getName()))) {
                            throw new FieldException("property " +  className + "." + field.getName() + " is not a valid uuid");
                        }
                    }
                    return;
                }

                if (field.get(clazz) == null) {
                    throw new FieldException("property " +  className + "." + field.getName() + " can't be null");
                }

            } catch (FieldException | IllegalAccessException e) {
                throw new FieldException(e.getMessage());
            }
        });
    }

    private String UUID;

    public boolean hasUUID() {
        return UUID != null && !UUID.isEmpty();
    }
}
