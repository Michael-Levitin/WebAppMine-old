import ru.javawebinar.webapp.model.Link;

import java.lang.reflect.Field;

public class Main {
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

    int i = 5;
    Link l1 = new Link("JavaWebinar", "javawebinar.ru");
    Link l2 = l1;
    Link l3 = new Link(l1);
    System.out.println(l1.getClass());
    System.out.println(l1.equals(l3));
    System.out.println(l1);

    System.out.println(Link.EMPTY);
    System.out.println(Link.empty());
    Field f = Link.class.getDeclaredField("url");
    f.setAccessible(true);
    Link l = new Link("fghfh", "URL");
    System.out.println(l instanceof Link);
    System.out.println(Link.class.isInstance(l));
    System.out.println(f.get(l));
    System.out.println(l.getUrl());
  }
}
