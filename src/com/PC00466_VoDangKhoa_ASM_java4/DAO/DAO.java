package com.PC00466_VoDangKhoa_ASM_java4.DAO;

import java.util.List;

public abstract class DAO<Entity, PK> {
   abstract public Entity create(Entity entity);
   abstract public Entity update(Entity entity);
   abstract public Entity remove(String id);
   abstract public List<Entity> findAll();
}
