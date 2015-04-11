
package com.lingxiang2014;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Order implements Serializable {

	private static final long serialVersionUID = -3078342809727773232L;

	public enum Direction {

		asc,

		desc;

		public static Direction fromString(String value) {
			return Direction.valueOf(value.toLowerCase());
		}
	}

	private static final Direction DEFAULT_DIRECTION = Direction.desc;

	private String property;

	private Direction direction = DEFAULT_DIRECTION;

	public Order() {
	}

	public Order(String property, Direction direction) {
		this.property = property;
		this.direction = direction;
	}

	public static Order asc(String property) {
		return new Order(property, Direction.asc);
	}

	public static Order desc(String property) {
		return new Order(property, Direction.desc);
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Order other = (Order) obj;
		return new EqualsBuilder().append(getProperty(), other.getProperty()).append(getDirection(), other.getDirection()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(getProperty()).append(getDirection()).toHashCode();
	}

}