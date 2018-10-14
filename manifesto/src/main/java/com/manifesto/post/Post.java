package com.manifesto.post;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.manifesto.user.User;

@Entity
public class Post {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;
    private String text;
    private Double latitude;
    private Double longitude;
    private Date time;
    private String type;
    
    @Column(name = "event_name")
    private String eventName;
    
    @Column(name = "escape_route")
    private String escapeRoute;
    
    @Column(name = "event_id")
    private int eventId;

	@ManyToOne
	@JoinColumn(name = "userId")
    private User user;
    
    public Post() {
    	
    }
    


	public Post(int id, String image, String text, Double latitude, Double longitude, Date time, String type,
			String eventName, String escapeRoute, int eventId, User user) {
		super();
		this.id = id;
		this.image = image;
		this.text = text;
		this.latitude = latitude;
		this.longitude = longitude;
		this.time = time;
		this.type = type;
		this.eventName = eventName;
		this.escapeRoute = escapeRoute;
		this.eventId = eventId;
		this.user = user;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEscapeRoute() {
		return escapeRoute;
	}

	public void setEscapeRoute(String escapeRoute) {
		this.escapeRoute = escapeRoute;
	}

	public int getEventId() {
		return eventId;
	}


	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	
}