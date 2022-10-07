package GENE;

/* COSC 1P03 Genome Assignment 3 version 1.0
 By Shawki Sha'aban, ID: 7356108
 Date: March 11, 2022
 */

public class MyGene implements Genome, someAlphabet{
    final String GENE;


    public MyGene (String GENE){
        this.GENE = GENE;

    }//constructor


    public String toString(){
        return GENE;
    }

// This method will return an int representing the length
//of the genome sequence.
    @Override
    public int Card() {
        int cardinalty = GENE.length();
        return cardinalty;
    }

    @Override
    // This method will clone the entire genome
    // by creating a brand new instance of Genome and specifying
    //the current genome sequence
    public Genome Clone() {
       MyGene CloneG = new MyGene(GENE);
        return CloneG;
    }

    // This method will Concatenate the two genome sequences
    //n a brand-new Genome object will be created containing the new genome sequence
    @Override
    public Genome ConCat(Genome g) {
        String p =GENE + g;
        return new MyGene(p);
    }

    //This method will will check if the genome sequence of the current genome is the same as
    //the genome passed as a parameter
    @Override
    public boolean Equal(Genome g) {


        if (g.toString()==GENE) {
            return true;

        } else {
            return false;
        }
    }

    //This method changes each character in the genome sequence,
    // if a random probability satisfies the threshold, then it will be changed to a different character.
    @Override
    public Genome Mutate(double p) {
        int numb;
        char[] Gn= GENE.toCharArray();
        String s ="";
        for(int i = 0; i<Card();i++){
            if(Math.random()<p){
                do
                    numb =(int) (Math.random()*4);
                while(alphabet[numb]==Gn[i]);
                s+= alphabet[numb];
            }
            else //throw new UsageException();
                s+=Gn;
        }
        return new MyGene(s);
    }

// This method Will create a new genome object based on the current sequence and the genome passed
//sequence. It creates a brand-new Genome object where the characters in indices 'i'
    @Override
    public Genome OnePointCrossOver(Genome g, int i) {
        Genome oneP;
        char OPC1[] = GENE.toCharArray();
        char OPC2[] = g.toString().toCharArray();
        String s;
        if (this.Card() == g.Card()){
            OPC1[i]=OPC2[i];
        } else throw new UsageException();

        s = new String(OPC1);

        oneP = new MyGene(s);

        return oneP;
    }

// This method Will create a new genome object based on the current sequence and the genome passed
//sequence.  The index i is passed, where 0 ≤ i < (current cardinality) and index j is
//passed, where 0 ≤ j < (current cardinality).
    @Override
    public Genome TwoPointCrossOver(Genome g, int i, int j) {
        Genome twoP;
        char TPC1[] = GENE.toCharArray();
        char TPC2[] = g.toString().toCharArray();
        String s;
        if (this.Card()==g.Card()){
            for(int sb = i; sb <= j; sb++){
                TPC1[sb]= TPC2[sb];
            }
        }else throw new UsageException();
        s = new String(TPC1);
        twoP = new MyGene(s);
        return twoP;
    }
// This method will create a brand-new Genome object that contains the current data
//as reversed
    @Override
    public Genome Inversion(){
        Genome inv;
        char ch[] = GENE.toCharArray();
        String inverse = "";
        for(int i = ch.length-1; i>=0;i--){
            inverse += ch[i];
        }
        inv = new MyGene(inverse);
        return inv;
    }
}


