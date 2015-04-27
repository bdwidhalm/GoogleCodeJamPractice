import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class GsonTesting
{
  public static void main(String[] args)
  {
    Gson gson = new Gson();
    BagOfPrimitives obj = new BagOfPrimitives();
    String json = gson.toJson(obj);

    System.out.println("Original JSON data: ");
    System.out.println(json);



    JsonObject object = gson.toJsonTree(obj).getAsJsonObject();
    object.addProperty("valueAdded", "I added this");
    object.addProperty("valueAddedAgain", "I added this too");



    System.out.println();
    System.out.println("Added to JSON data: ");
    System.out.println(object.toString());


    object.remove("value2");
    object.addProperty("value2", "updated this");



    System.out.println();
    System.out.println("Updated JSON data: ");
    System.out.println(object.toString());

  }
}
