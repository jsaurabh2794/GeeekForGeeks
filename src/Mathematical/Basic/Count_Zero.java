package Mathematical.Basic;

public class Count_Zero {
    /*Given a number d, representing the number of digits of a number.
    Find the total count of positive integers which have at-least one zero in them and consist d or less digits*/

    //for every length 1 to d , calculate no of digits having atleast one zero
    // eg for length 3-> first place 1-9 choise, first place cant be zero otherwise it will not be 3 digit and reamaining will be 10digit
    // 9*10*10 - 9*9*9 = 171  (all no of having at least one zero - remove all number who does not have zero nd do for all d)

}
