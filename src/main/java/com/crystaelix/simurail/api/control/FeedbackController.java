package com.crystaelix.simurail.api.control;


public interface FeedbackController {

	void setFrequency(double frequency);

	void setDampingRate(double dampingRate);

	double updateForce(double inertia, double offset, double velocity, double maxForce, double timeStep);

	double getForce();
	
	void reset();
}
