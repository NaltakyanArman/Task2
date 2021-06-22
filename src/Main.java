import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        List<Cartoon> cartoons = cartoonFactory(6);
        List<Movie> movies = movieFactory(5);
        List<Abstract> abstracts = new ArrayList<>(11);
        abstracts.addAll(cartoons);
        abstracts.addAll(movies);
        Collections.sort(abstracts);
        Collections.reverse(abstracts);
        for (Abstract anAbstract:abstracts) {
            if(anAbstract instanceof Cartoon){
                continue;
            }
            System.out.println(anAbstract.getTitle() + " " + anAbstract.getRating());
            break;
        }
    }

    public static List<Cartoon> cartoonFactory(int count) {
        List<Cartoon> cartoonList = new ArrayList<Cartoon>(count);
        for (int i = 0; i < count; i++) {
            Cartoon cartoon = new Cartoon(randomTitle());
            cartoonList.add(cartoon);
        }
        return cartoonList;
    }

    public static List<Movie> movieFactory(int count) {
        List<Movie> movieList = new ArrayList<Movie>(count);
        for (int i = 0; i < count; i++) {
            Movie movie = new Movie(randomTitle());
            movieList.add(movie);
        }
        return movieList;
    }

    private static String randomTitle() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        String output = generatedString.substring(0, 1).toUpperCase() + generatedString.substring(1);
        return output;
    }
}


