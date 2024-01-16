package abDataHandelers;

/**
 *
 * The Signal class represents a signal object that has dm, sigma, time, sample,
 * and downfact properties.
 *
 * It implements the Comparable interface to allow sorting signals based on
 * their dm values.
 *
 * @author Mustafa Al-Shebeeb
 *
 * @version 1.0
 * @since 04-14-2023
 */
public class Signal implements Comparable<Signal> {
	// Signal properties
	private double dm;
	private double sigma;
	private double time;
	private int sample;
	private int downfact;

	/**
	 * Creates a Signal object with default property values of 0.
	 */
	public Signal() {
		dm = sigma = time = sample = downfact = 0;
	}

	/**
	 *
	 * Creates a Signal object from a line in a file.
	 *
	 * @param line a line from a file containing signal properties separated by
	 *             whitespace.
	 */
	public Signal(String line) {
		String[] tokens = line.split("\\s+");
		dm = Double.parseDouble(tokens[0]);
		sigma = Double.parseDouble(tokens[1]);
		time = Double.parseDouble(tokens[2]);
		sample = Integer.parseInt(tokens[3]);
		downfact = Integer.parseInt(tokens[4]);
	}

	@Override

	/**
	 *
	 * Compares this Signal object to another Signal object based on their dm
	 * values.
	 *
	 * @param otherSignal the Signal object to compare to.
	 * @return -1 if this Signal object's dm value is less than the otherSignal's dm
	 *         value, 1 if this Signal object's dm value is greater than the
	 *         otherSignal's dm value, 0 if the two Signal objects have equal dm
	 *         values.
	 */
	public int compareTo(Signal otherSignal) {
		if (this.dm < otherSignal.dm) {
			return -1;
		} else if (this.dm > otherSignal.dm) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Gets the dm value of this Signal.
	 *
	 * @return the dm value of this Signal.
	 */
	public double getDm() {
		return dm;
	}

	/**
	 * Sets the dm value of this Signal.
	 *
	 * @param dm the new dm value.
	 */
	public void setDm(double dm) {
		this.dm = dm;
	}

	/**
	 * Gets the sigma value of this Signal.
	 *
	 * @return the sigma value of this Signal.
	 */
	public double getSigma() {
		return sigma;
	}

	/**
	 * Sets the sigma value of this Signal.
	 *
	 * @param sigma the new sigma value.
	 */
	public void setSigma(double sigma) {
		this.sigma = sigma;
	}

	/**
	 * Gets the time value of this Signal.
	 *
	 * @return the time value of this Signal.
	 */
	public double getTime() {
		return time;
	}

	/**
	 * Sets the time value of this Signal.
	 *
	 * @param time the new time value.
	 */
	public void setTime(double time) {
		this.time = time;
	}

	/**
	 * Gets the sample value of this Signal.
	 *
	 * @return the sample value of this Signal.
	 */
	public int getSample() {
		return sample;
	}

	/**
	 * Sets the sample value of this Signal.
	 *
	 * @param sample the new sample value.
	 */
	public void setSample(int sample) {
		this.sample = sample;
	}

	/**
	 * Gets the downfact value of this Signal.
	 *
	 * @return the downfact value of this Signal.
	 */
	public int getDownfact() {
		return downfact;
	}

	/**
	 * Sets the downfact value of this Signal.
	 *
	 * @param downfact the new downfact value.
	 */
	public void setDownfact(int downfact) {
		this.downfact = downfact;
	}

}
