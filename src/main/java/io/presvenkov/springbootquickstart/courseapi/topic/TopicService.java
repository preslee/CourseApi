package io.presvenkov.springbootquickstart.courseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
        new Topic("1", "COMP101", "Introduction to CS"),
        new Topic("2", "COMP161", "Introduction to Java"),
        new Topic("3", "COMP151", "Introduction to Computer Architecture"),
        new Topic("4", "COMP241", "Introduction to Machine Learning")));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

	public void updateTopic(String id, Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if(t.getId().equals(topic.getId())) {
                topics.set(i, topic);
                return;
            }
        }
	}

	public void deleteTopic(String id) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.remove(i);
            }
        }
	}
}