package co.ds.stripes;

import co.ds.bean.Topic;
import co.ds.mybatis.mapper.TopicMapper;
import com.google.inject.Inject;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import java.util.List;

@UrlBinding("/topic")
public class TopicAction  extends BaseAction {
    private static final String LIST_FORWARD = "/WEB-INF/jsp/topic/list.jsp";
    private TopicMapper topicMapper;
    private List<Topic> topics;

    @Inject
    public TopicAction(final TopicMapper topicMapper){
        this.topicMapper = topicMapper;
    }

    public Resolution list() {
        topics = topicMapper.list();
        return new ForwardResolution(LIST_FORWARD);
    }

    public List<Topic> getTopics() {
        return this.topics;
    }

    public void setTopics(final List<Topic> topics) {
        this.topics = topics;
    }
}
