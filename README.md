Steps to Run/Test:

- Project includes a maven configuration file as pom.xml, most IDEs should be able to automatically detect and import
 dependencies, but if not "mvn compile" can be used

- Entry point/main method is in ASTakeHomeApp.java, which can be ran

- The following method can be altered to change the search output:

List<RestaurantCuisine> output =
restaurantService.search(restaurantCuisineList, null, 5, 5, 25, "russ");

The first parameter (restaurantCuisineList) should be untouched

The second parameter is a String for restaurant name

The third parameter is an Integer for customer rating

The fourth parameter is an Integer for distance

The fifth parameter is an Integer for price

The sixth parameter is a String for cuisine name

- Results of the search are printed to System.out

