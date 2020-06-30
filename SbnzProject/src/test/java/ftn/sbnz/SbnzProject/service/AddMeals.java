package ftn.sbnz.SbnzProject.service;


import ftn.sbnz.SbnzProject.model.MealEnum;
import ftn.sbnz.SbnzProject.model.MealRecipe;
import ftn.sbnz.SbnzProject.repository.MealRecipeRepository;
import ftn.sbnz.SbnzProject.repository.MealRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddMeals {

    @Autowired
    MealRecipeRepository mealRecipeRepository;

    @Test
    public void addBreakfasts() {
        List<String> ingredients1 = new ArrayList<>(Arrays.asList(
                "2 medium tomatillos (about 4 ounces), husked and rinsed",
                "1 jalapeno pepper (remove seeds for less heat)",
                "1 small red onion, quartered",
                "2 cups roughly chopped fresh cilantro (leaves and tender stems)",
                "Juice of 1 lime",
                "Kosher salt and freshly ground pepper",
                "4 ounces dried chorizo, thinly sliced",
                "3 1/2 cups frozen shredded or diced hash brown potatoes (about 1 pound)",
                "4 large eggs, lightly beaten",
                "1 16-ounce can low-sodium refried beans",
                "4 10-inch flour tortillas, warmed",
                "1 cup shredded mozzarella cheese (about 4 ounces)"
        ));
        mealRecipeRepository.save(new MealRecipe("Breakfast Burritos with Chorizo", MealEnum.BREAKFAST, ingredients1, "4 servings", 710, 34, 30, 78, 6, 11));

        List<String> ingredients2 = new ArrayList<>(Arrays.asList(
                "One 8-ounce ripe avocado, halved, pitted and peeled",
                "Fine salt and freshly ground black pepper",
                "4 slices whole grain or whole wheat bread",
                "1 clove garlic, peeled and halved",
                "2 tablespoons extra-virgin olive oil or unsalted butter, softened",
                "Flaky sea salt, for serving",
                "Crushed red pepper flakes, optional"
        ));
        mealRecipeRepository.save(new MealRecipe("Avocado Toasts", MealEnum.BREAKFAST, ingredients2, "4 servings", 160, 4, 10, 16, 2, 1));

        List<String> ingredients3 = new ArrayList<>(Arrays.asList(
                "1 teaspoon ground cinnamon",
                "1/4 teaspoon ground nutmeg",
                "2 tablespoons sugar",
                "4 tablespoons butter",
                "4 eggs",
                "1/4 cup milk",
                "1/2 teaspoon vanilla extract",
                "8 slices challah, brioche, or white bread",
                "1/2 cup maple syrup, warmed"
        ));
        mealRecipeRepository.save(new MealRecipe("French Toast", MealEnum.BREAKFAST, ingredients3, "4 servings", 446, 11, 18, 60, 34, 9.5));

        List<String> ingredients4 = new ArrayList<>(Arrays.asList(
                "1 cup unsweetened frozen peaches",
                "1 tablespoon honey, plus more to taste",
                "1/4 teaspoon vanilla extract",
                "1/8 teaspoon ground cinnamon",
                "Pinch ground nutmeg",
                "Pinch ground ginger",
                "1/2 cup nonfat or 1 percent lowfat milk",
                "1/2 cup nonfat plain yogurt"
        ));
        mealRecipeRepository.save(new MealRecipe("Peach Pie Smoothie", MealEnum.BREAKFAST, ingredients4, "1 serving, serving size: 2 cups", 212, 10, 0, 47, 41, 0));

        List<String> ingredients5 = new ArrayList<>(Arrays.asList(
                "Two 4-ounce packets unsweetened frozen acai puree",
                "1 medium banana",
                "1/2 cup blueberries",
                "1 tablespoon honey",
                "3 tablespoons granola",
                "2 tablespoons pomegranate seeds",
                "1 tablespoon unsweetened coconut flakes"
        ));
        mealRecipeRepository.save(new MealRecipe("Acai Breakfast Bowl", MealEnum.BREAKFAST, ingredients5, "1 breakfast bowl", 400, 5, 10, 78, 44, 4.5));

        List<String> ingredients6 = new ArrayList<>(Arrays.asList(
                "1/3 to 1/2 cup liquid such as dairy milk, almond, cashew or coconut milk",
                "1/3 to 1/2 cup old-fashioned rolled oats",
                "1/3 to 1/2 cup yogurt, optional",
                "1 teaspoon chia seeds, optional but highly recommended",
                "1/2 banana, mashed, optional",
                "Serving suggestions: fruit (fresh or dried), nuts, nut butter, seeds, protein powder, granola, coconut, spices, citrus zest and vanilla extract"
        ));
        mealRecipeRepository.save(new MealRecipe("Overnight Oats", MealEnum.BREAKFAST, ingredients6, "1 serving", 190, 6, 4, 34, 8, 0));

        List<String> ingredients7 = new ArrayList<>(Arrays.asList(
                "1 whole-wheat English muffin, split",
                "1 small tomato, seeded and diced",
                "1 teaspoon extra-virgin olive oil",
                "1 thin slice (1/2 ounce) Canadian bacon, diced",
                "1/4 cup shredded part-skim mozzarella cheese",
                "Chopped fresh basil, for garnish"
        ));
        mealRecipeRepository.save(new MealRecipe("English-Muffin Breakfast Pizza", MealEnum.BREAKFAST, ingredients7, "1 serving", 300, 17, 13, 32, 0, 5));

    }

    @Test
    public void addLunches() {
        List<String> ingredients1 = new ArrayList<>(Arrays.asList(
                "1 bunch cilantro, chopped",
                "1 clove garlic",
                "1/2 teaspoon chipotle chile powder, plus more to taste",
                "Kosher salt",
                "1 cup white rice",
                "1 15-ounce can black bean soup (preferably spicy)",
                "1 10-ounce package frozen chopped spinach, thawed and squeezed dry",
                "2 cups frozen corn (preferably fire-roasted), thawed",
                "1 large tomato, diced",
                "Juice of 1 lime",
                "4 burrito-size flour tortillas",
                "2 cups shredded pepper jack cheese (about 8 ounces)"
        ));
        mealRecipeRepository.save(new MealRecipe("Chipotle Veggie Burritos", MealEnum.LUNCH, ingredients1, "4 servings", 934, 34, 27, 140, 0, 12));

        List<String> ingredients2 = new ArrayList<>(Arrays.asList(
                "2 lemons",
                "Kosher salt and freshly ground pepper",
                "1/2 medium red onion, thinly sliced",
                "1 medium carrot, shredded",
                "1/4 cup vegetable oil",
                "2 cups long-grain white rice",
                "2 tablespoons rice wine vinegar",
                "2 teaspoons packed light brown sugar",
                "1 Kirby cucumber, seeded and diced",
                "1/2 cup chopped salted roasted peanuts",
                "1/2 cup fresh cilantro, roughly chopped",
                "1/2 cup fresh mint, roughly chopped",
                "1/2 cup fresh basil, roughly chopped",
                "1 bunch watercress, tough stems removed, leaves torn"
        ));
        mealRecipeRepository.save(new MealRecipe("Lemon-Herb Rice Salad", MealEnum.LUNCH, ingredients2, "6 servings", 378, 0, 15.5, 55, 4, 1));

        List<String> ingredients3 = new ArrayList<>(Arrays.asList(
                "4 to 5 cups dashi, recipe follows",
                "2 tablespoons brown miso paste, plus more to taste",
                "2 tablespoons white miso paste, plus more to taste",
                "6 ounces firm tofu, cut into 1/2-inch cubes",
                "2 scallions, white and green, thinly sliced on the diagonal ",
                "2 tablespoons aji mirin (sweetened rice wine), optional",
                "6 cups cold water",
                "One 12-inch long piece of kombu, wiped with a damp cloth",
                "One .88-ounce/25 grams package shaved dried bonito flakes"
        ));
        mealRecipeRepository.save(new MealRecipe("Miso Soup", MealEnum.LUNCH, ingredients3, "4 servings", 115, 12, 4, 8, 2, 0));

        List<String> ingredients4 = new ArrayList<>(Arrays.asList(
                "4 bell peppers (any color)",
                "Kosher salt and freshly ground black pepper",
                "4 teaspoons olive oil ",
                "2 cloves garlic, finely chopped",
                "1 small onion, chopped",
                "8 ounces 90-percent lean ground beef",
                "1 teaspoon dried oregano",
                "1/2 teaspoon ground cinnamon",
                "1/2 teaspoon ground cumin",
                "2 tablespoons tomato paste",
                "1 cup low-sodium chicken broth",
                "1/2 cup long-grain white rice",
                "1/3 cup brown lentils",
                "1 tablespoon chopped fresh dill, parsley or 1/4 teaspoon dried mint"
        ));
        mealRecipeRepository.save(new MealRecipe("Lightened-Up Stuffed Peppers", MealEnum.LUNCH, ingredients4, "4 servings", 320, 20, 11, 35, 5, 3));


        List<String> ingredients5 = new ArrayList<>(Arrays.asList(
                "3 tablespoons fresh lemon juice",
                "2 tablespoons extra-virgin olive oil",
                "Kosher salt",
                "1 bunch kale, ribs removed, leaves very thinly sliced",
                "1/4 cup dates",
                "1 Honeycrisp apple",
                "1/4 cup slivered almonds, toasted",
                "1 ounce Pecorino, finely grated (1/4 cup)",
                "Freshly ground black pepper"
        ));
        mealRecipeRepository.save(new MealRecipe("Kale and Apple Salad", MealEnum.LUNCH, ingredients5, "6 servings", 151, 5, 8.5, 17, 8, 1.5));


        List<String> ingredients6 = new ArrayList<>(Arrays.asList(
                "1 1/4 pounds skinless, boneless chicken thighs (about 6)",
                "1 cup jarred salsa",
                "Juice of 2 limes, plus wedges for serving",
                "1/4 cup vegetable oil",
                "1/4 cup sour cream",
                "1 bunch cilantro, leaves chopped (about 3/4 cup)",
                "Kosher salt and freshly ground pepper",
                "1 14-ounce can hearts of palm, drained and sliced 1/2 inch thick",
                "1 avocado, chopped",
                "6 radishes, thinly sliced",
                "16 corn tortillas",
                "Shredded lettuce and/or diced red onion, for topping"
        ));
        mealRecipeRepository.save(new MealRecipe("Chicken Tacos with Avocado Salad", MealEnum.LUNCH, ingredients6, "4 servings", 566, 29, 34, 37, 0, 7));


        List<String> ingredients7 = new ArrayList<>(Arrays.asList(
                "1 medium pork tenderloin (about 1 pound)",
                "3 cloves garlic, grated",
                "1 1/4 teaspoons dried oregano",
                "1 1/4 teaspoons ground cumin",
                "Kosher salt and freshly ground pepper",
                "1 large sweet potato, peeled and cut into 3/4-inch pieces",
                "3 cups broccoli florets (about 8 ounces)",
                "3 tablespoons extra-virgin olive oil",
                "3/4 cup quinoa",
                "Juice of 1 orange",
                "1 tablespoon red wine vinegar",
                "1/4 teaspoon red pepper flakes"
        ));
        mealRecipeRepository.save(new MealRecipe("Pork and Broccoli Grain Bowl", MealEnum.LUNCH, ingredients7, "4 servings", 420, 30, 16, 38, 7, 3));


        List<String> ingredients8 = new ArrayList<>(Arrays.asList(
                "1/2 Hass avocado, pitted",
                "2 tablespoons white balsamic or white wine vinegar",
                "1 tablespoon finely chopped fresh oregano",
                "1 tablespoon fat-free plain Greek yogurt",
                "2 large cloves garlic, minced",
                "12 slices whole wheat or sprouted grain bread, lightly toasted, if desired",
                "1 cup packed baby arugula or mizuna",
                "2 1/2 ounces thinly sliced ready-to-eat smoked tofu or smoked mozzarella cheese",
                "1/2 cup thinly sliced red onion",
                "1/3 cup packed sun-dried tomatoes, fully rehydrated",
                "1/2 cup thinly sliced unpeeled English cucumber",
                "1/3 cup thinly sliced pepperoncini (about 1 ounce)",
                "2 1/2 ounces thinly sliced provolone",
                "1 large freshly roasted orange or red bell pepper, cut into 12 pieces, or 1/3 cup store-bought roasted peppers"
                ));
        mealRecipeRepository.save(new MealRecipe("Veggie Lover's Club Sandwich", MealEnum.LUNCH, ingredients8, "4 servings", 389, 23, 12, 49, 12, 4));

        List<String> ingredients9 = new ArrayList<>(Arrays.asList(
                "1 cup unsweetened puffed millet or puffed rice cereal",
                "1 cup frozen fire-roasted corn, thawed",
                "1 13-ounce bag frozen mixed grains (or 1 1/2 cups cooked brown rice)",
                "1 14-ounce can adzuki beans, drained and rinsed",
                "1 cup grape tomatoes, halved",
                "3 scallions, thinly sliced",
                "1/2 cup chopped fresh cilantro",
                "Juice of 2 limes",
                "1 4-ounce container sprouts, bottoms trimmed",
                "1/2 cup crumbled goat cheese (about 3 ounces)",
                "2 tablespoons toasted sesame oil",
                "Kosher salt and freshly ground pepper"
                ));
        mealRecipeRepository.save(new MealRecipe("California Grain Salad", MealEnum.LUNCH, ingredients9, "4 servings", 416, 16, 13, 62, 0, 3));

        List<String> ingredients10 = new ArrayList<>(Arrays.asList(
                "1 head cauliflower, stem removed",
                "1 cup shredded mozzarella cheese",
                "1/4 cup grated parmesan cheese",
                "1/2 teaspoon dried oregano",
                "Kosher salt",
                "1/4 teaspoon garlic powder",
                "2 large eggs, lightly beaten",
                "1/2 cup marinara sauce",
                "Sliced bell peppers and onion, for topping"
                ));
        mealRecipeRepository.save(new MealRecipe("Pizza with Cauliflower Crust", MealEnum.LUNCH, ingredients10, "4 servings", 211, 16, 11, 15, 7, 5));

    }
}
