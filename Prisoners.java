import java.util.Random;

// "100 Prisoners" problem, using the optimal strategy
public class Prisoners
{
    int[] drawers;
    int numTries;
    
    public Prisoners (int numPrisoners, int numTries)
    {
        this.drawers = new int[numPrisoners];
        this.numTries = numTries;
        
        for(int a = 0; a < numPrisoners; a++)
        {
            drawers[a] = a + 1;
        }
        
    }
    
    /**
     * Shuffles the values in the drawer array field member.
     * Shuffling is done by iterating through the array
     * and swapping the ith drawer's value with that of
     * a random drawer. 
     */

    private void shuffleDrawers()
    {
        Random random = new Random();
        
        for(int i = 0; i < this.drawers.length; i++)
        {
            // Store value of a random drawer
            int randomIndex = random.nextInt(this.drawers.length);
            int temp = this.drawers[randomIndex];
            
            // Swap values of the two drawers (ith and random)
            this.drawers[randomIndex] = this.drawers[i];
            this.drawers[i] = temp;
            
        }
      
    }
    
    /**
     * Processes the 100 Prisoners Problem using the optimal solution.
     * 
     * @return boolean value of whether or not the prisoners succeeded
     */
    public boolean processOptimal()
    {
        
        boolean prisonerFail = false;
        int prisonerNumber = 1;
        
        while((prisonerNumber < this.drawers.length) && !(prisonerFail))
        {
            int drawersOpened = 0;
            boolean found = false;
            int currentDrawer = prisonerNumber;

            while((drawersOpened < this.numTries) && !(found))
            {
                
                if(prisonerNumber == this.drawers[currentDrawer - 1])
                    found = true;
                
                currentDrawer = this.drawers[currentDrawer - 1];
                
                drawersOpened++;                
            }
            
            if(found == false)
            {
                prisonerFail = true;
            }
            
            prisonerNumber++;
            
        }
        
        return !prisonerFail;
    }
    
    public static void main (String args[])
    {
        
        final int numPrisoners = 100;
        
        Prisoners prisoners = new Prisoners(numPrisoners, 75);
        prisoners.shuffleDrawers();
        
        boolean isSuccess = prisoners.processOptimal();
        
        if (isSuccess)
        {
            System.out.println("Prisoners have succeeded!");
        }
        else
        {
            System.out.println("Prisoners have failed.");
        }
        
    }
    
    
}