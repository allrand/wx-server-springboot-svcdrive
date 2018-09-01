package com.nousunde.wxma.entity;

import net.sf.json.JSONObject;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "tb_dock")
public class Dock {
    @Override
    public String toString() {
        JSONObject jsonObject = JSONObject.fromObject(this);
        return jsonObject.toString();
    }

    @Id
    @GeneratedValue
    @Column(name = "dock_id")
    private long DockId;
    private String Barcode;

    private String Owner;
    @ColumnDefault("0.00")
    private Double PC;//Percent Complete
    @ColumnDefault("")
    private String DOA;//Details of artifacts产出物的詳情

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }
    public Double getPC() {
        return PC;
    }

    public void setPC(Double PC) {
        this.PC = PC;
    }

    public String getDOA() {
        return DOA;
    }

    public void setDOA(String DOA) {
        this.DOA = DOA;
    }

    public long getDockId() {
        return DockId;
    }

    public void setDockId(long dockId) {
        DockId = dockId;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }
}
