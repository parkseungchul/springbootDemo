package com.psc.demo001.domain;

import com.psc.demo001.domain.embed.Pks_DeptEmp;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dept_emp")
public class Mapping {

    @EmbeddedId
    private Pks_DeptEmp deptEmp;
    private String dname;
    private String ename;

    @Override
    public String toString() {
        return "Mapping{" +
                "deptEmp=" + deptEmp.toString() +
                ", dname='" + dname + '\'' +
                ", ename='" + ename + '\'' +
                '}';
    }
}
