package com.backend.houserenting.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class HouseDto {

		@NotBlank
	    private String title;
		@Min(50)
	    private String description;
		@Min(1)
	    private int wc;
		@Min(0)
	    private int rooms;
		@Min(0)
	    private float price;
		@NotBlank
	    private String location;

	    public HouseDto() {
	    }

		public HouseDto(String title, String description, int wc, int rooms, Float price, String location) {
			this.title = title;
			this.description = description;
			this.wc = wc;
			this.rooms = rooms;
			this.price = price;
			this.location = location;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getWc() {
			return wc;
		}

		public void setWc(int wc) {
			this.wc = wc;
		}

		public int getRooms() {
			return rooms;
		}

		public void setRooms(int rooms) {
			this.rooms = rooms;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}
	    
}
