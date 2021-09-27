package com.haxon.larp.Models;

import android.widget.CheckBox;

public class InfoModel {

    boolean waterHeater,elecFurnace,xbox,AC,spaceHeat, tvPlasma;
    boolean tvLED,cable,cfl,vaccumm,hairdry,fridge,kettle,oven,toastoven;
    boolean cellPhone,pc,laptop,wifiRouter,ps4;

    public InfoModel(boolean waterHeater, boolean elecFurnace, boolean xbox, boolean AC, boolean spaceHeat, boolean tvPlasma, boolean tvLED, boolean cable, boolean cfl, boolean vaccumm, boolean hairdry, boolean fridge, boolean kettle, boolean oven, boolean toastoven, boolean cellPhone, boolean pc, boolean laptop, boolean wifiRouter, boolean ps4) {
        this.waterHeater = waterHeater;
        this.elecFurnace = elecFurnace;
        this.xbox = xbox;
        this.AC = AC;
        this.spaceHeat = spaceHeat;
        this.tvPlasma = tvPlasma;
        this.tvLED = tvLED;
        this.cable = cable;
        this.cfl = cfl;
        this.vaccumm = vaccumm;
        this.hairdry = hairdry;
        this.fridge = fridge;
        this.kettle = kettle;
        this.oven = oven;
        this.toastoven = toastoven;
        this.cellPhone = cellPhone;
        this.pc = pc;
        this.laptop = laptop;
        this.wifiRouter = wifiRouter;
        this.ps4 = ps4;
    }

    public boolean isWaterHeater() {
        return waterHeater;
    }

    public void setWaterHeater(boolean waterHeater) {
        this.waterHeater = waterHeater;
    }

    public boolean isElecFurnace() {
        return elecFurnace;
    }

    public void setElecFurnace(boolean elecFurnace) {
        this.elecFurnace = elecFurnace;
    }

    public boolean isXbox() {
        return xbox;
    }

    public void setXbox(boolean xbox) {
        this.xbox = xbox;
    }

    public boolean isAC() {
        return AC;
    }

    public void setAC(boolean AC) {
        this.AC = AC;
    }

    public boolean isSpaceHeat() {
        return spaceHeat;
    }

    public void setSpaceHeat(boolean spaceHeat) {
        this.spaceHeat = spaceHeat;
    }

    public boolean isTvPlasma() {
        return tvPlasma;
    }

    public void setTvPlasma(boolean tvPlasma) {
        this.tvPlasma = tvPlasma;
    }

    public boolean isTvLED() {
        return tvLED;
    }

    public void setTvLED(boolean tvLED) {
        this.tvLED = tvLED;
    }

    public boolean isCable() {
        return cable;
    }

    public void setCable(boolean cable) {
        this.cable = cable;
    }

    public boolean isCfl() {
        return cfl;
    }

    public void setCfl(boolean cfl) {
        this.cfl = cfl;
    }

    public boolean isVaccumm() {
        return vaccumm;
    }

    public void setVaccumm(boolean vaccumm) {
        this.vaccumm = vaccumm;
    }

    public boolean isHairdry() {
        return hairdry;
    }

    public void setHairdry(boolean hairdry) {
        this.hairdry = hairdry;
    }

    public boolean isFridge() {
        return fridge;
    }

    public void setFridge(boolean fridge) {
        this.fridge = fridge;
    }

    public boolean isKettle() {
        return kettle;
    }

    public void setKettle(boolean kettle) {
        this.kettle = kettle;
    }

    public boolean isOven() {
        return oven;
    }

    public void setOven(boolean oven) {
        this.oven = oven;
    }

    public boolean isToastoven() {
        return toastoven;
    }

    public void setToastoven(boolean toastoven) {
        this.toastoven = toastoven;
    }

    public boolean isCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(boolean cellPhone) {
        this.cellPhone = cellPhone;
    }

    public boolean isPc() {
        return pc;
    }

    public void setPc(boolean pc) {
        this.pc = pc;
    }

    public boolean isLaptop() {
        return laptop;
    }

    public void setLaptop(boolean laptop) {
        this.laptop = laptop;
    }

    public boolean isWifiRouter() {
        return wifiRouter;
    }

    public void setWifiRouter(boolean wifiRouter) {
        this.wifiRouter = wifiRouter;
    }

    public boolean isPs4() {
        return ps4;
    }

    public void setPs4(boolean ps4) {
        this.ps4 = ps4;
    }
}
