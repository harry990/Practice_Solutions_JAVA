import java.util.*;
import java.util.stream.Collectors;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UptakeQ2 {
	public static String solution(String S) {
        // write your code in Java SE 8

        List<Photo> photos =new ArrayList<>();
        Set<String> cities=new LinkedHashSet<>();
        String[] lines = S.split("[\\r\\n]+");
        for (int i = 0; i < lines.length; i++) {
        	Photo pic=null;
            String[] tokens = lines[i].split(",");
            for (int j = 0; j < tokens.length; j++) {
                String[] tok = tokens[0].split("\\.");
                pic = new Photo(i, tokens[1], getDate(tokens[2]), tok[1]);
                cities.add(tokens[1]);

             }
            photos.add(pic);
        }

        List<Photo> temp_pics=new ArrayList<>();

        for (Photo pc:photos) {
            temp_pics.add(pc);

        }
        List<Photo> result=new ArrayList<>();

        for (String c:cities) {
        	// sorted by each city
            List<Photo> sortcity = temp_pics.stream()
                    .filter(p -> p.getCity().equalsIgnoreCase(c))
                    .collect(Collectors.toList());

            // sort by date for each city
            Collections.sort(sortcity, new Comparator<Photo>() {
                @Override
                public int compare(Photo p1, Photo p2) {
                    return p1.getDate().compareTo(p2.getDate());
                }
            });

            // sequence added as per city and date
            for (int i = 0; i < sortcity.size(); i++) {
                // print as per total digits in array size
                String format = String.format("%0"+(int)(Math.log10(sortcity.size())+1)+"d", i+1);
                //System.out.println(format);
                //System.out.println((int)(Math.log10(sortcity.size())+1));
                Photo pic = sortcity.get(i);
                pic.setSeq(format);
                result.add(pic);
            }

        }

        // sort as per original id
        Collections.sort(result, new Comparator<Photo>() {
            @Override
            public int compare(Photo p1, Photo p2) {
                return p1.getId()-p2.getId();
            }
        });

        StringBuilder stringBuilder=new StringBuilder();
        for (Photo img:result) {
            stringBuilder.append(img.toString());
            stringBuilder.append("\n");
        }
        return  stringBuilder.toString();
    }

    public static Date getDate(String datetime){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return df.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();

    }

    public static class Photo {

        int id;
        String city;
        String seq;
        String extension;
        Date date;

        public Photo(int id, String city, Date date, String extension) {
            this.id = id;
            this.city = city;
            this.date = date;
            this.extension = extension;
        }

        @Override
        public String toString() {
            return city.trim()+seq +"."+extension;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getSeq() {
            return seq;
        }

        public void setSeq(String seq) {
            this.seq = seq;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

    }
    
    public static void main(String args[]) 
    { 
    	UptakeQ2 t = new UptakeQ2(); 
    	//String datetimeString = "photo.jpg, Warsaw, 2013-09-05 14:08:15\\njohn.png, London, 2015-06-20 15:13:22\\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\\nEiffel.jpg, Paris, 2015-07-23 08:03:02\\npisatower.jpg, Paris, 2015-07-22 23:59:59\\nBOB.jpg, London, 2015-08-05 00:02:03\\nnotredame.png, Paris, 2015-09-01 12:00:00\\nme.jpg, Warsaw, 2013-09-06 15:40:22\\na.png, Warsaw, 2016-02-13 13:33:50\\nb.jpg, Warsaw, 2016-01-02 15:12:22\\nc.jpg, Warsaw, 2016-01-02 14:34:30\\nd.jpg, Warsaw, 2016-01-02 15:15:01\\ne.png, Warsaw, 2016-01-02 09:49:09\\nf.png, Warsaw, 2016-01-02 10:55:32\\ng.jpg, Warsaw, 2016-02-29 22:13:11";
		String S = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
        "john.png, London, 2015-06-20 15:13:22\n" +
        "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
        "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
        "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
        "BOB.jpg, London, 2015-08-05 00:02:03\n" +
        "notredame.png, Paris, 2015-09-01 12:00:00\n" +
        "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
        "a.png, Warsaw, 2016-02-13 13:33:50\n" +
        "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
        "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
        "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
        "e.png, Warsaw, 2016-01-02 09:49:09\n" +
        "f.png, Warsaw, 2016-01-02 10:55:32\n" +
        "g.jpg, Warsaw, 2016-02-29 22:13:11";

    	System.out.println(UptakeQ2.solution(S));

    }
}
