package diet;

/**
 * Represents a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {
	
	private String name;
	private Food food;
	private double calories;
	private double proteins;
	private double carbs;
	private double fat;
	private double quantity;
	
	
	public Recipe(String name, Food f) {
		this.name=name;
		this.food=f;
		this.calories=0;
		this.proteins=0;
		this.carbs=0;
		this.fat=0;
		this.quantity=0;
	}

	/**
	 * Adds the given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 * @return the same Recipe object, it allows method chaining.
	 */
	public Recipe addIngredient(String material, double quantity) {


		calories+=food.getRawMaterial(material).getCalories()*quantity;
		carbs+=food.getRawMaterial(material).getCarbs()*quantity;
		fat+=food.getRawMaterial(material).getFat()*quantity;
		proteins+=food.getRawMaterial(material).getProteins()*quantity;
		this.quantity+=quantity;
		
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		return calories/quantity;
	}
	

	@Override
	public double getProteins() {
		return proteins/quantity;
	}

	@Override
	public double getCarbs() {
		return carbs/quantity;
	}

	@Override
	public double getFat() {
		return fat/quantity;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}:
	 * a recipe expresses nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return true;
	}
	
}
