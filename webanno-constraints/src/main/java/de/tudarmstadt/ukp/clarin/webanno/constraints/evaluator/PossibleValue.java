package de.tudarmstadt.ukp.clarin.webanno.constraints.evaluator;
/**
 * Class for containing possible values based on a rule and evaluation 
 * Also includes flag values
 * @author aakash
 *
 */
public class PossibleValue implements Comparable<PossibleValue>
{
    private final String value;
    private final boolean important;

    public PossibleValue(String aValue, boolean aImportant)
    {
        value = aValue;
        important = aImportant;
    }

    public String getValue()
    {
        return value;
    }

    public boolean isImportant()
    {
        return important;
    }
    
    

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (important ? 1231 : 1237);
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PossibleValue other = (PossibleValue) obj;
        if (important != other.important)
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        }
        else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "PossibleValue [value=" + value + ", important=" + important + "]";
    }

    /* 
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(PossibleValue o)
    {
        if(!this.isImportant() && o.isImportant()){
            return 1; 
        }else if(this.isImportant() && !o.isImportant()){
            return -1;
        }else
            return 0;
       
    }
}