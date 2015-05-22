package com.serket.cloud.service.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.serket.cloud.util.Page;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseServiceImpl<T> extends SqlSessionDaoSupport implements
        BaseService<T> {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    public void sett(SqlSessionTemplate sessionTemplate) {
        super.setSqlSessionTemplate(sessionTemplate);
    }

    protected Class<T> t;
    private String mapperNamespace;

    public BaseServiceImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass()
                .getGenericSuperclass();
        t = (Class) pt.getActualTypeArguments()[0];
        mapperNamespace = t.getName().replace("bean", "mapper") + "Mapper";
    }

    public void list(Page p) {
        String mapper = mapperNamespace + ".list";
        p.setList(getSqlSession().selectList(mapper, p));

    }

    public List<T> findAll() {
        String mapper = mapperNamespace + ".findAll";
        return getSqlSession().selectList(mapper);

    }

    public void save(T obj) {
        String mapper = mapperNamespace + ".save";
        getSqlSession().insert(mapper, obj);
    }

    public void update(T obj) {
        String mapper = mapperNamespace + ".update";
        getSqlSession().update(mapper, obj);
    }

    public T getById(String id) {
        String mapper = mapperNamespace + ".getById";
        return getSqlSession().selectOne(mapper, id);
    }

    public void del(String[] ids) {
        String mapper = mapperNamespace + ".del";
        getSqlSession().delete(mapper, ids);
    }
}
