package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;

public class ArrayStorage implements IStorrage {

  private static final int LIMIT = 100;
  private Resume[] array = new Resume[LIMIT];

  @Override
  public void clear() {
    Arrays.fill(array, null);
  }

  @Override
  public void save(Resume r) {
      for (int i = 0; i < LIMIT; i++) {
        Resume resume = array[i];
        if(resume == null)
          array[i] = r;
        else if (r.equals(resume))
          throw new IllegalStateException("Already present");
      }
  }

  @Override
  public void update(Resume r) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].getUuid().equals(r.getUuid())) {
        array[i] = r;
        return;
      }
    }
  }

  @Override
  public Resume load(String uuid) {
    for (Resume resume : array) {
      if (resume.getUuid().equals(uuid))
        return resume;
    }
    return null;
  }

  @Override
  public void delete(String uuid) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].getUuid().equals(uuid)) {
        array[i] = null;
        return;
      }
    }
  }

  @Override
  public Collection<Resume> getAllSorted() {
    return null;
  }

  @Override
  public int size() {
    int arraySize = 0;
    for (Resume resume : array) {
      if (resume.getUuid() == null)
        break;
      arraySize++;
    }
    return arraySize;
  }
}
