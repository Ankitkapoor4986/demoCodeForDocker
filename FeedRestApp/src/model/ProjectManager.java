package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Database;
import dao.Project;
import dto.FeedObjects;

public class ProjectManager {
	
	
	public ArrayList<FeedObjects> GetFeeds()throws Exception {
		ArrayList<FeedObjects> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.GetFeeds(connection);
//			feeds = GetFeedsData();
		} catch (Exception e) {
			System.out.println(e);
			throw e;

		}
		return feeds;
	}

	private ArrayList<FeedObjects> GetFeedsData() {
		ArrayList<FeedObjects> list = new ArrayList<FeedObjects>();
		FeedObjects objects = new FeedObjects();
		objects.setDescription("Hello World");
		objects.setTitle("I am the world");
		objects.setUrl("www.helloworld.com");
		list.add(objects);
		return list;
	}

}
