public abstract class Abstract implements Comparable<Abstract> {
    protected String title;
    protected double rating;

    public Abstract(String title) {
        this.title = title;
        this.rating = Constants.MIN_RATING + (Math.random() * Constants.MAX_RATING);
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public int compareTo(Abstract o) {
        return Double.compare(this.rating, o.rating);
    }
}