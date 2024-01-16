package abTests;

class Dog implements Comparable<Dog> {
	public Integer age;

	public Dog(int a) {
		age = a;
	}

	@Override
	public int compareTo(Dog o) {
		return age.compareTo(o.age);
	}

	@Override
	public String toString() {
		return "Dog Age = " + age;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Dog))
			return false;
		else
			return age == ((Dog) o).age;
	}
}