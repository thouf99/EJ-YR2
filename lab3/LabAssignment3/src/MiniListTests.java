public class MiniListTests {

    //add elements to the array
    public static void main(String[] args) {

        MyMiniList<String> ml = new MyMiniList<String>();

        ml.add("aliceblue");
        ml.add("antiquewhite");
        ml.add("aqua");
        ml.add("aquamarine");
        ml.add("azure");
        ml.add("beige");
        ml.add("bisque");
        ml.add("black");
        ml.add("blanchedalmond");
        ml.add("blue");
        ml.add("blueviolet");
        ml.add("brown");
        ml.add("burlywood");
        ml.add("cadetblue");
        ml.add("chartreuse");
        ml.add("chocolate");
        ml.add("coral");
        ml.add("cornflowerblue");
        ml.add("cornsilk");
        ml.add("crimson");
        ml.add("cyan");
        ml.add("darkblue");
        ml.add("darkcyan");
        ml.add("darkgoldenrod");
        ml.add("darkgray");
        ml.add("darkgreen");
        ml.add("darkgrey");
        ml.add("darkkhaki");
        ml.add("darkmagenta");
        ml.add("darkolivegreen");
        ml.add("coral");

        //get element at index
        String atIndex = ml.get(23);
        System.out.println("At the 23rd Location is" + atIndex);

        //get first occurance of
        int n = ml.getIndex("coral");
        System.out.println("coral is at " + n);

        //set value at an index
        ml.set(9, "testUpdate");
        ml.set(23, "testUpdate2");

        //remove by object
        ml.remove("crimson");
        //remove by index
        ml.remove(7);

        for(int i = 0; i< ml.size(); i++){
            System.out.println(ml.get(i));
        }
        //clear
        ml.clear();
        System.out.println("the size of ml is " + ml.size());

    }
}

