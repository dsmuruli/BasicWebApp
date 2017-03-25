package co.ds.stripes;

import co.ds.bean.Topic;
import co.ds.mybatis.mapper.TopicMapper;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TopicActionTest extends AbstractBaseActionTest<TopicAction> {

    public static final Integer TOPIC_ID = 111333;
    public static final String TOPIC_NAME = "TOPIC NAME";
    private static final String LIST_FORWARD = "/WEB-INF/jsp/topic/list.jsp";
    private static final String HOME_REDIRECT = "/home";

    @ConstructorParam
    @Mock
    private TopicMapper topicMapper;
    @Captor
    private ArgumentCaptor<Topic> topicArgumentCaptor;

    @Test
    public void should_display_list() throws Exception {
        when(topicMapper.list()).thenReturn(new ArrayList<Topic>() {{
            add(getTopic());
        }});
        trip.execute();
        assertEquals("Action should have a topic list of 1", 1,action.getTopics().size());
        assertEquals("Unexpected resolution", LIST_FORWARD, trip.getDestination());
        assertEquals("Subscriber should have name of TOPIC NAME", TOPIC_NAME,action.getTopics().get(0).getName());
    }

    	/* HELPERS */
        private Topic getTopic() {
            return new Topic() {{
                setId(TOPIC_ID);
                setName(TOPIC_NAME);

            }};
        }

}
