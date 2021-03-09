package ru.javawebinar.webapp.model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Resume {
  private String uuid;
  private String fullName;
  private String homePage;
  private String location;
  private List<Contact> contacts;
  private List<Section> sections;

  public Resume(String fullName, String location) {
    this(UUID.randomUUID().toString(), fullName, location);
  } // generates unique number/string

  public Resume(String uuid, String fullName, String location) {
    this.uuid = uuid;
    this.fullName = fullName;
    this.location = location;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Resume resume = (Resume) o;
    return uuid.equals(resume.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid);
  }

  public String getUuid() {
    return uuid;
  }

  public String getFullName() {
    return fullName;
  }

  public String getHomePage() {
    return homePage;
  }

  public String getLocation() {
    return location;
  }

  public List<Contact> getContacts() {
    return contacts;
  }

  public List<Section> getSection() {
    return sections;
  }

  public void addSection(Section s) {
    sections.add(s);
  }

  public void addContact(Contact c) {
    contacts.add(c);
  }

}