package json.demo.entity;

import org.springframework.stereotype.Repository;
//扫描不到实体类 所以添加了这个注解
@Repository
public class Category {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();

    }
}