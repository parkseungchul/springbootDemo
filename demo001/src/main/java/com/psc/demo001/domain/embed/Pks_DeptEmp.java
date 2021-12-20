package com.psc.demo001.domain.embed;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Pks_DeptEmp implements Serializable {

    private Integer deptno;
    private Integer empno;

    @Override
    public String toString() {
        return "Pks_DeptEmp{" +
                "deptno=" + deptno +
                ", empno=" + empno +
                '}';
    }
}
