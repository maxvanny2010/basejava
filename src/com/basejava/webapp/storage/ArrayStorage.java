package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int countSize = 0;

    public void save(Resume resume) {
        if(countSize < storage.length) {
            int index = index(resume.getUuid());
            if(index != -1) {
                System.out.println("Резюме " + resume + " уже существует.");
            } else {
                storage[countSize] = resume;
                countSize++;
                System.out.println("Резюме " + resume + " добавлено.");
            }
        } else {
            System.out.println("Resume can't add to array. Array is full.");
        }
    }

    public void update(Resume resume) {
        int index = index(resume.getUuid());
        if(index != -1) {
            storage[index] = resume;
            System.out.println("Резюме " + resume + " обновлено.");
        } else {
            System.out.println("Резюме " + resume.getUuid() + " не существует.");
        }
    }

    public Resume get(String uuid) {
        int index = index(uuid);
        if(index != -1) {
            System.out.println("Резюме " + uuid + " получено.");
            return storage[index];
        } else {
            System.out.println("Резюме " + uuid + " не существует.");
            return null;
        }
    }

    public void delete(String uuid) {
        int index = index(uuid);
        if(index != -1) {
            storage[index] = storage[countSize - 1];
            storage[countSize - 1] = null;
            countSize--;
            System.out.println("Резюме " + uuid + " удалено.");
        } else {
            System.out.println("Резюме " + uuid + " не существует.");
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, countSize, null);
        countSize = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, countSize);
    }

    private int index(String uuid) {
        for(int i = 0; i <= countSize - 1; i++) {
            if(storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return countSize;
    }
}