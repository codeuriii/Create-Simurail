package com.crystaelix.simurail.api.control;


public class PDController implements FeedbackController {

	private double frequency;
	private double dampingRate;

	private double force = 0;

	public PDController() {
	}

	public PDController(double frequency, double dampingRate) {
		this.frequency = Math.abs(frequency);
		this.dampingRate = Math.abs(dampingRate);
	}

	@Override
	public void setFrequency(double frequency) {
		this.frequency = Math.abs(frequency);
	}

	@Override
	public void setDampingRate(double dampingRate) {
		this.dampingRate = Math.abs(dampingRate);
	}

	@Override
	public double updateForce(double inertia, double offset, double velocity, double maxForce, double timeStep) {
		if(timeStep <= 0 || inertia <= 0) {
			return force = 0;
		}
		double stiffness = frequency * frequency;
		double damping = 2 * frequency * dampingRate;
		double numerator = stiffness * offset - damping * velocity;
		double denominator = 1 + damping * timeStep + stiffness * timeStep * timeStep;
		force = inertia * numerator / denominator;
		return force = Math.clamp(force, -Math.abs(maxForce), Math.abs(maxForce));
	}

	@Override
	public double getForce() {
		return force;
	}

	@Override
	public void reset() {
		force = 0;
	}
}
