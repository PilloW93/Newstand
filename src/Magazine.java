public class Magazine {

    private final String title; //Title of the Newspaper
    //private final String publisher;
    private final int numberOfYearlyIssues;
    //private final String genre;

    /**
     * Creates an instance of a Newspaper.
     *
     * @param title Title of the Newspaper
     * @param numberOfYearlyIssues The number of issues issued pr year
     */
    public Magazine(String title, int numberOfYearlyIssues ) {
        this.title = title;
        //this.publisher = publisher;
        this.numberOfYearlyIssues = numberOfYearlyIssues;
        //this.genre = genre;
    }

    /**
     * Returns the title of the newspaper
     * @return the title of the newspaper
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Returns the number of yearly issues.
     * @return the number of yearly issues.
     */
    public int getNumberOfYearlyIssues()
    {
        return this.numberOfYearlyIssues;
    }

   //// public String getPublisher()
    {
        //return this.publisher;
    }

    //public String getGenre()
    {
        //return this.genre;
    }
}

