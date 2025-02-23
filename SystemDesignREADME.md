[1] Functional Requirements

Of course, you can’t design the whole Facebook in the next 1 hour. So, discuss with your interviewer what features he wants you to design in 1 hour if he has not stated it already.

Should the design include a "detailed" discussion of the following features —
- Signup/Login of users?
- Send/Accept Friend Requests?
- Personalized NewsFeed for a user?
- Can the post contain images/text or video as well?

Basically, get a very clear idea of what needs to be designed in the next 1 hour. 

________

[2] Non-Functional Requirements

Think about what would you expect out of the system as a user in terms of speed, security, reliability etc.
- Probably 2 seconds is acceptable to display a user’s feed
- It’s okay to show a friend’s post maybe a few minutes late but make sure that system is able to read & display some data.
- We should protect user’s data for security reasons

________

[3] Constraints & Capacity Estimates

In simple terms, What’s the scale we are dealing with and how many approx. servers needed? 
- How many daily active users? 10k or 10M or 1Billion?
- Avg. size of 1 post?
- How many servers are needed to serve the traffic?
- How much bandwidth is required to open Facebook and scroll the feed?

________

[4] API schema

Come up with the functional APIs for the system like:
- CRUD operations on a post.
- Send/Accept/Reject Friend Request APIs
- Get User NewsFeed

Preferably, follow REST protocols and define:
Method Type: POST/PUT/GET/DELETE
Method Name: NewsFeed
Request Parameters: In URL or body
Response HTTP Codes: 2xx/3xx/4xx/5xx

________

[5] High-level System Design

You need to have a lot of experience to answer this most complex section. For starters:
- Start identifying your services like UserService, FeedService, NotificationService
- Start mentioning which API would go to which service
- Think if there are certain things that can be handled asynchronously

There’s a LOT more. Check the first comment of this post in detail.
________

[6] Database Design

I prefer discussing this after I high-level design my system. 

- Discuss what are the tables and relevant columns 
- Discuss the relationship between the User/Post/Feed. One-to-one or one-to-many?
- More importantly, discuss tradeoffs for why you are choosing SQL vs No-SQL.
- Any key-value cache for improving performance

________

At each point, pause and let your interviewer absorb things, don’t be in a hurry. They will steer you on the right path if you’re discussing something which he is not interested in.

If there’s still some time left, discuss the extra problems:
- Ranking logic for posts? How to solve the Hot Users problem who have millions of followers?
- How to do Monitoring/Alerting/Observability

I hope it helps!

All the Best for your next one! ❤️