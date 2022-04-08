package com.demo.assignment5;

public class TestList {
    public static void main(String[] args) {
        System.out.println("1. Create empty list");
        DynamicList<Integer> list = new DynamicList<Integer>();
        DynamicListIterator<Integer> itr;

        System.out.println("2. list length: " + list.length());
        System.out.println("3. list Empty?: " + list.empty());

        System.out.println("4. adding: " + 10);
        list.add(10);
        System.out.println("5. adding: " + 20);
        list.add(20);
        System.out.println("6. adding: " + 30);
        list.add(30);
        System.out.println("7. adding: " + 40);
        list.add(40);
        System.out.println("8. adding: " + 50);
        list.add(50);

        System.out.println("9. list length: " + list.length());
        System.out.println("10. list Empty?: " + list.empty());
        System.out.println("11. offEnd?: " + list.offEnd());

        System.out.println("12. advance");
        list.advance();
        System.out.println("13. advance");
        list.advance();

        itr = new DynamicListIterator<Integer>(list);
        System.out.print("List: ");
        while(itr.hasNext()) {
            System.out.print(itr.next() + " -> ");
        }
        System.out.println("null");

        System.out.println("14. adding: " + 35);
        list.add(35);

        System.out.println("15. get: " + list.get());

        System.out.println("16. advance 5 times.");
        list.advance();
        list.advance();
        list.advance();
        list.advance();
        list.advance();

        System.out.println("17. list offEnd?: "+ list.offEnd());

        try {
            System.out.println("18. get when cursor is offEnd.");
            list.get();
        } catch (Exception e) {
            System.out.println("Exception - " + e.getMessage());
        }

        System.out.println("19. adding: " + 5);
        list.add(5);

        System.out.println("20. get: " + list.get());

        System.out.println("21. list to front.");
        list.toFront();

        System.out.println("22. get: " + list.get());

        System.out.println("23. find Item 30.");
        list.find(30);
        System.out.println("24. get: " + list.get());

        try {
            System.out.println("25. find Item 35. when cursor is at right of 35.");
            list.find(35);
            System.out.println("26. get: when cursor is at null.");
            list.get();
        } catch (Exception e) {
            System.out.println("Exception - " + e.getMessage());
        }

        itr = new DynamicListIterator<Integer>(list);
        System.out.print("List: ");
        while(itr.hasNext()) {
            System.out.print(itr.next() + " -> ");
        }
        System.out.println("null");

        System.out.println("27. list length." + list.length());
        System.out.println("28. list to Front: ");
        list.toFront();
        System.out.println("29. remove: " + list.remove());

        System.out.println("30. list length: " + list.length());


        itr = new DynamicListIterator<Integer>(list);
        System.out.print("List: ");
        while(itr.hasNext()) {
            System.out.print(itr.next() + " -> ");
        }
        System.out.println("null");

        System.out.println("31. remove: " + list.remove());
        System.out.println("32. remove: " + list.remove());
        System.out.println("33. advance by 4 times.");
        list.advance();
        list.advance();
        list.advance();
        list.advance();

        try {
            System.out.println("34. remove when cursor is offEnd.");
            list.remove();
        } catch (Exception e) {
            System.out.println("Exception - " + e.getMessage());
        }
    }
}
