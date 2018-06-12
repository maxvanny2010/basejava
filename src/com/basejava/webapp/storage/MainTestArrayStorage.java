package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class MainTestArrayStorage {
    ArrayStorage storage = new ArrayStorage();
    public static void aroundSave(Resume oneResume) {
        System.out.print("SAVE(): ");
        System.out.println("Добавление резюме " + oneResume + "...");
    }

    public static void aroundUpdate(Resume oneResume) {
        System.out.print("UPDATE(): ");
        System.out.println("Обновление резюме " + oneResume + "...");
    }

    public static  void aroundGet(Resume oneResume) {
        System.out.print("GET(): ");
        System.out.println("Получение резюме " + oneResume + "...");
    }

    public static  void aroundDelete(Resume oneResume) {
        System.out.print("DELETE(): ");
        System.out.println("Удаление резюме: " + oneResume + "...");
    }

    public static  void aroundClear() {
        System.out.print("CLEAR(): ");
        System.out.println("Очистка массива...");
    }

    public static  void aroundGetAll(ArrayStorage oneStorage) {
        Resume[] Store = oneStorage.getAll();
        System.out.println("GET_All[элементы массива]: " + Arrays.toString(Store));
        System.out.println();
    }
    public void setSave(Resume resume){
        aroundSave(resume);
        storage.save(resume);
        aroundGetAll(storage);
    }
    public void setUpdate(Resume resume){
        aroundUpdate(resume);
        storage.update(resume);
        aroundGetAll(storage);
    }
    public void setGet(Resume resume){
        aroundGet(resume);
        storage.get("4");
        System.out.println();
    }
    public void setDelete(Resume resume){
        aroundDelete(resume);
        storage.delete(resume.getUuid());
        aroundGetAll(storage);
    }
    public void setClear(Resume resume){
        aroundClear();
        storage.clear();
        System.out.println("В массиве: " + storage.size() + " резюме.");
        aroundGetAll(storage);
    }

    public void ResumeAll() {

        Resume resume = new Resume();
        resume.setUuid("0");
        Resume resume1 = new Resume();
        resume.setUuid("1");
        Resume resume2 = new Resume();
        resume.setUuid("2");
        Resume resume3 = new Resume();
        resume.setUuid("3");
        Resume resume4 = new Resume();
        resume.setUuid("4");
//****************************
        System.out.println();
        setSave(resume1);
//****************************
        setSave(resume2);
//*****************************
        setSave(resume2);
//*****************************
        setSave(resume3);
//*****************************
        setGet(resume4);
//*****************************
        setGet(resume2);
//*****************************
        setUpdate(resume);
//*****************************
        setUpdate(resume2);
//*****************************
        setDelete(resume1);
//*****************************
        setDelete(resume4);
//*****************************
        setClear(null);
//******************************/

    }
}
