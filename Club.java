import java.util.ArrayList;
import java.util.Iterator;
/**;
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // Define any necessary fields here ...
    private ArrayList<Membership> socios;

    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        socios = new ArrayList<Membership>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        socios.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return socios.size();
    }

    /** 
     * Calcula el numero de socios que se dieron de alta en un mes determinado. 
     * El año no nos importa. En caso de que el parametro contenga un valor 
     * no valido se muestra por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @return El numero de socios que se dieron de alta dicho mes
     */
    public int joinedMonth(int month)
    {
        int numSocios = 0;
        if(month > 12 || month < 1)
        {
            System.out.println("¡¡ERROR!! El mes es incorrecto");
            return -1;
        }
        else
        {
            for(Membership socio:socios)
            {
                if(month == socio.getMonth())
                {
                    numSocios++;
                }
            }
        }
        return numSocios;
    }

    /** 
     * Todos los socios que se han dado de alta un determinado mes de un determinado año se
     * dan de baja. En caso de que el parametro month contenga un valor no valido se muestra 
     * por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @param year El año en el que estamos interesados
     * @return Una coleccion con los socios que se han dado de baja del club
     */
    public ArrayList purge(int month,int year)
    {
        ArrayList<Membership> sociosBaja;
        sociosBaja = new ArrayList<Membership>();
        Iterator<Membership> listaSocio = socios.iterator();
        if(month > 12 || month < 1)
        {
            System.out.println("¡¡ERROR!! la fecha es incorrecta");
            return null;
        }
        else
        {
            while (listaSocio.hasNext())
            {
                Membership mienbro = listaSocio.next();
                if (month  == mienbro.getMonth() && year == mienbro.getYear())
                {
                    sociosBaja.add(mienbro);
                    listaSocio.remove();
                }
            }
        }
        return sociosBaja;
    }
}
