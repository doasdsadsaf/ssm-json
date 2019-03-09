package json.demo.entity;

import org.springframework.stereotype.Repository;

import java.util.List;

//扫描不到实体类 所以添加了这个注解
@Repository
public class Category {
    private List<String> urls;

    private Integer id;

    private String name;

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

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