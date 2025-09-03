
# Enterprise Supply Chain Management 

   ![Enterprise supply chain management platform](https://github.com/Reaishma/Project-portfolio/blob/main/Screenshot_20250903-150435_1.jpg)

A comprehensive Spring Boot application that provides a unified dashboard for managing enterprise supply chain operations across multiple platforms including SAP, Oracle, Microsoft Dynamics, and more. This project implements the **APICS Supply Chain Operations Reference (SCOR)** model and integrates modern supply chain management frameworks.

# 🚀 Live Demo 

View live demo on https://reaishma.github.io/Enterprise-supply-chain-management-dashboard-/

## 🏭 Supply Chain Management Framework

This project implements a comprehensive Supply Chain Management (SCM) framework that integrates multiple enterprise platforms to provide unified visibility and control over supply chain operations, following industry best practices and standards.

![overview](https://github.com/Reaishma/Enterprise-supply-chain-management-dashboard-/blob/main/Screenshot_20250903-174501_1.jpg)

### APICS Framework Integration

This project is built upon the **APICS Supply Chain Operations Reference (SCOR)** model, which provides a structured approach to supply chain management:

#### SCOR Model Implementation

##### 1. **PLAN** - Supply Chain Planning
- **Demand Planning**: Blue Yonder integration for advanced demand forecasting
- **Supply Planning**: SAP integration for material requirements planning
- **Financial Planning**: Oracle SCM for budget and cost planning
- **Risk Planning**: Comprehensive risk assessment and mitigation strategies

##### 2. **SOURCE** - Procurement and Sourcing
- **Supplier Management**: Multi-platform supplier performance tracking
- **Strategic Sourcing**: Cost optimization and supplier selection
- **Purchase Order Management**: Automated PO creation and tracking
- **Contract Management**: Supplier agreements and compliance monitoring

##### 3. **MAKE** - Manufacturing and Production
- **Production Planning**: Microsoft Dynamics 365 integration
- **Capacity Management**: Real-time capacity monitoring
- **Quality Management**: Quality control and assurance processes
- **Manufacturing Execution**: Shop floor control and monitoring

##### 4. **DELIVER** - Order Fulfillment and Logistics
- **Order Management**: End-to-end order processing
- **Warehouse Management**: Inventory tracking and optimization
- **Transportation Management**: Transporeon and Cerasis integration
- **Customer Service**: Delivery performance and customer satisfaction

##### 5. **RETURN** - Returns Management
- **Return Processing**: Reverse logistics management
- **Quality Control**: Returned goods inspection and processing
- **Refurbishment**: Product reconditioning and resale
- **Disposal**: Sustainable disposal and recycling processes

#### APICS Best Practices Implemented

1. **Continuous Improvement (Kaizen)**
   - Real-time performance monitoring
   - KPI tracking and optimization
   - Process improvement recommendations

2. **Lean Supply Chain Principles**
   - Waste reduction strategies
   - Just-in-time inventory management
   - Value stream mapping

3. **Six Sigma Quality Management**
   - Statistical process control
   - Defect reduction programs
   - Quality metrics tracking

4. **Total Quality Management (TQM)**
   - Customer-focused quality initiatives
   - Supplier quality programs
   - Continuous quality improvement

### Framework Components

#### 1. Multi-Platform Integration
- **SAP Supply Chain Management**: Procurement & Planning
- **Oracle SCM**: Analytics & Visibility  
- **Microsoft Dynamics 365**: Operations & Logistics
- **Blue Yonder**: Demand Planning & Optimization
- **Zoho Inventory**: Small-Medium Enterprise Management
- **Transporeon**: Transportation Management
- **Cerasis**: Freight & Logistics

#### 2. Core SCM Modules

##### Procurement Management
- Purchase Order creation and tracking
- Supplier performance monitoring
- Contract management
- Spend analytics

##### Inventory Management
- Real-time inventory tracking
- Stock level optimization
- Warehouse management
- Demand forecasting

##### Logistics & Transportation
- Shipment tracking
- Route optimization
- Carrier management
- Delivery performance metrics

##### Risk Management
- Supply chain risk assessment
- Alert management system
- Compliance monitoring
- Business continuity planning

##### Analytics & Reporting
- Real-time dashboards
- Performance KPIs
- Predictive analytics
- Custom reporting

## 🚀 Features

### Real-time Operations
- **Live Dashboard**: Interactive dashboard with real-time metrics and updates
- **Multi-platform Integration**: Unified view across SAP, Oracle, Microsoft Dynamics, and other SCM platforms
- **Real-time Alerts**: Instant notifications for supply chain disruptions
- **Live Analytics**: Dynamic charts and metrics visualization

### Core Functionality
- **Inventory Management and Transportation Management**: Track and update inventory levels across different products and locations,management shipments,stock alertsand track freight cost.
- **Purchase Order Management**: Create, approve, and track purchase orders
- **Supplier Management**: Monitor supplier performance and relationships
- **Risk Management**: Identify and mitigate supply chain risks
- **Compliance Tracking**: Ensure regulatory compliance across operations

### Advanced Features
- **Predictive Analytics**: AI-powered demand forecasting
- **Route Optimization**: Intelligent logistics planning
- **Cost Analytics**: Comprehensive spend analysis
- **Performance Metrics**: Real-time KPI monitoring
- **Integration APIs**: RESTful APIs for third-party integrations
- **Warehouse operations management**:
manage warehouse operations and track utilisation in real time 
- **interaction with multiple systems**:
SAP,SCM, Oracle SCM, dynamics 365, blue yonder,transporean, cerasis,four kitesand E2Open

## 🏗️ Architecture

### Backend (Spring Boot)
The backend is built using Spring Boot 3.2.0 with a comprehensive architecture:

#### Project Structure
```
src/main/java/com/scm/dashboard/
├── SupplyChainDashboardApplication.java    # Main Spring Boot application
├── config/
│   ├── WebConfig.java                      # CORS and web configuration
│   └── DataInitializer.java               # Sample data initialization
├── controller/
│   ├── DashboardController.java            # Main dashboard APIs
│   ├── SAPController.java                  # SAP integration APIs
│   ├── InventoryController.java            # Inventory management APIs
│   ├── AlertController.java                # Alert management APIs
│   └── StaticController.java               # Static file serving
├── model/
│   ├── DashboardMetrics.java               # Dashboard metrics entity
│   ├── PurchaseOrder.java                  # Purchase order entity
│   ├── Inventory.java                      # Inventory item entity
│   └── Alert.java                          # Alert entity
├── repository/
│   ├── DashboardMetricsRepository.java     # Dashboard data access
│   ├── PurchaseOrderRepository.java        # Purchase order data access
│   ├── InventoryRepository.java            # Inventory data access
│   └── AlertRepository.java                # Alert data access
└── service/
    ├── DashboardService.java               # Dashboard business logic
    ├── PurchaseOrderService.java           # Purchase order services
    ├── InventoryService.java               # Inventory management services
    └── AlertService.java                   # Alert management services
```

#### Technologies Used
- **Framework**: Spring Boot 3.2.0 with Java 17
- **Database**: H2 in-memory database (development) / PostgreSQL (production)
- **API**: RESTful APIs for all SCM operations
- **Real-time Updates**: WebSocket support for live data
- **Security**: Spring Security with JWT authentication
- **Caching**: Redis for performance optimization

### Frontend
The frontend is located in `src/main/resources/static/dashboard.html` and features:

- **Technology**: Vanilla JavaScript with Bootstrap 5
- **Charts**: Chart.js and D3.js for advanced visualizations
- **Styling**: Custom CSS with modern design patterns
- **Real-time**: Automatic data refresh and live updates
- **Responsive**: Mobile-first design approach

### Integration Layer
- **APIs**: RESTful APIs for external system integration
- **Message Queues**: RabbitMQ for asynchronous processing
- **Data Sync**: Real-time synchronization across platforms
- **Error Handling**: Comprehensive error management and retry logic

## 📊 Supply Chain Metrics & KPIs

### APICS-Based Performance Metrics

#### Operational Excellence Metrics
- **Perfect Order Rate**: Percentage of orders delivered complete, on-time, damage-free
- **Order Fulfillment Cycle Time**: Time from order receipt to delivery
- **Inventory Turnover**: Rate of inventory movement and optimization
- **Supplier Performance**: Delivery accuracy, quality, and compliance metrics
- **Lead Time Variability**: Consistency in delivery times

#### Financial Performance Metrics
- **Total Supply Chain Cost**: Comprehensive cost analysis
- **Cost of Goods Sold (COGS)**: Direct costs of production
- **Working Capital Efficiency**: Cash flow optimization
- **Return on Assets (ROA)**: Asset utilization efficiency
- **Supply Chain ROI**: Return on supply chain investments

#### Customer Service Metrics
- **Fill Rate**: Percentage of customer orders fulfilled from stock
- **On-Time Delivery**: Delivery performance against commitments
- **Customer Satisfaction Score**: Customer feedback and ratings
- **Order Accuracy**: Correctness of order fulfillment

#### Innovation and Learning Metrics
- **Process Improvement Rate**: Continuous improvement initiatives
- **Technology Adoption**: Digital transformation progress
- **Employee Productivity**: Workforce efficiency metrics
- **Sustainability Metrics**: Environmental impact measurements

### Risk Metrics
- **Supply Risk Score**: Aggregated risk assessment
- **Compliance Rate**: Regulatory compliance percentage
- **Disruption Impact**: Cost and time impact of disruptions
- **Recovery Time**: Average time to recover from disruptions

## 🛠️ Installation & Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Git

### Running the Application

1. **Clone and run**:
```bash
git clone <repository-url>
cd supply-chain-dashboard
mvn spring-boot:run
```

2. **Access the application**:
- Dashboard: http://localhost:8080/dashboard.html
- API Documentation: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console

### Configuration

#### Application Properties (`src/main/resources/application.properties`)
```properties
# Server Configuration
server.port=8080
server.address=0.0.0.0

# Database Configuration
spring.datasource.url=jdbc:h2:mem:scmdb
spring.datasource.driver-class-name=org.h2.Driver
spring.h2.console.enabled=true

# JPA Configuration
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
```

## 📱 API Endpoints

### Dashboard APIs
- `GET /api/dashboard/metrics` - Get comprehensive dashboard metrics
- `GET /api/dashboard/status` - Get system health status

### Inventory Management
- `GET /api/inventory` - List all inventory items with filtering
- `POST /api/inventory` - Create new inventory item
- `PUT /api/inventory/{id}` - Update existing inventory item
- `DELETE /api/inventory/{id}` - Remove inventory item

### Purchase Orders (SAP Integration)
- `GET /api/sap/purchase-orders` - List purchase orders with pagination
- `POST /api/sap/purchase-orders` - Create new purchase order
- `PUT /api/sap/purchase-orders/{id}` - Update purchase order status
- `GET /api/sap/purchase-orders/{id}` - Get purchase order details

### Alert Management
- `GET /api/alerts` - List all alerts with filtering options
- `POST /api/alerts` - Create new custom alert
- `PUT /api/alerts/{id}/acknowledge` - Acknowledge alert
- `GET /api/alerts/unread-count` - Get count of unread alerts

## 🎨 UI/UX Features

### Design Elements
- **Modern Interface**: Clean, professional dashboard design following Material Design principles
- **Color-coded Platforms**: Different brand colors for SAP (blue), Oracle (red), Microsoft (cyan)
- **Interactive Components**: Hover effects, smooth transitions, and responsive feedback
- **Responsive Layout**: Optimized for desktop, tablet, and mobile devices
- **Real-time Updates**: Live data refresh without page reload

### Platform-Specific Interfaces
- **SAP Integration**: Procurement and planning modules
- **Oracle SCM**: Risk management and analytics
- **Microsoft Dynamics**: Warehouse and operations management
- **Blue Yonder**: Demand forecasting and optimization
- **Multi-platform Dashboard**: Unified view across all systems

### User Experience
- **Intuitive Navigation**: Tab-based interface for different platforms
- **Quick Actions**: One-click operations for common tasks
- **Visual Feedback**: Immediate response to user interactions
- **Progressive Enhancement**: Graceful fallbacks for older browsers

## 🔧 Technical Stack

### Backend Technologies
- **Spring Boot 3.2.0**: Main application framework
- **Spring Data JPA**: Database abstraction layer
- **Spring Security**: Authentication and authorization
- **H2 Database**: In-memory database for development
- **Maven**: Dependency management and build tool
- **Java 17**: Programming language

### Frontend Technologies
- **HTML5/CSS3**: Markup and styling
- **JavaScript ES6+**: Client-side programming
- **Bootstrap 5**: CSS framework for responsive design
- **Chart.js**: Data visualization library
- **D3.js**: Advanced data visualization
- **Font Awesome**: Icon library
- **Google Fonts**: Typography (Inter font family)

### Development Tools
- **Maven**: Build automation and dependency management
- **Git**: Version control system
- **H2 Console**: Database management interface
- **Spring Boot DevTools**: Development utilities and hot reload

## 📈 Supply Chain Optimization Features

### APICS-Driven Optimization

#### Demand Planning (PLAN)
- Historical data analysis and trend identification
- Seasonal pattern recognition and forecasting
- Machine learning-based demand prediction
- Safety stock optimization algorithms
- S&OP (Sales and Operations Planning) integration

#### Supplier Management (SOURCE)
- Supplier scorecards and performance benchmarking
- Risk assessment and mitigation strategies
- Supplier relationship management (SRM)
- Contract compliance monitoring
- Supplier diversity and sustainability tracking

#### Manufacturing Excellence (MAKE)
- Production scheduling optimization
- Capacity planning and utilization
- Quality management systems
- Lean manufacturing principles
- OEE (Overall Equipment Effectiveness) tracking

#### Logistics Optimization (DELIVER)
- Route planning and optimization algorithms
- Load optimization and consolidation
- Carrier selection and management
- Last-mile delivery optimization
- Customer service level agreements

#### Returns Management (RETURN)
- Reverse logistics optimization
- Return reason analysis
- Refurbishment and resale processes
- Warranty and service management
- Circular economy initiatives

### Cost Management
- Activity-based costing (ABC)
- Total cost of ownership (TCO) analysis
- Spend analysis and category management
- Budget tracking and variance analysis
- ROI calculation and optimization

## 🔍 Monitoring & Analytics

### Real-time Monitoring
- System health and performance monitoring
- Supply chain KPI tracking and alerting
- Exception management and escalation
- Compliance monitoring and reporting
- Business continuity monitoring

### Business Intelligence
- Executive dashboards and scorecards
- Operational reports and analytics
- Predictive analytics and forecasting
- Trend analysis and insights
- Benchmarking and best practices

### Data Integration
- Multi-source data aggregation and normalization
- Data quality management and validation
- Master data management (MDM)
- Real-time data synchronization
- API-first integration approach

## 🚀 Deployment on Replit

### Local Development
```bash
mvn clean compile
mvn spring-boot:run
```

### Replit Deployment
This application is optimized for deployment on Replit:

1. **Automatic Dependency Management**: Maven automatically handles all dependencies
2. **Port Configuration**: Application runs on port 8080 (configured for Replit)
3. **Database**: Uses H2 in-memory database for quick startup
4. **Static Files**: Dashboard served from `src/main/resources/static/`

### Production Configuration
- Configure production database (PostgreSQL) via environment variables
- Set up monitoring and logging
- Configure SSL certificates
- Enable production security features

## 🔒 Security Features

### Authentication & Authorization
- JWT-based authentication system
- Role-based access control (RBAC)
- Multi-factor authentication support
- Session management and timeout

### Data Security
- API rate limiting and throttling
- Data encryption at rest and in transit
- SQL injection prevention
- Cross-site scripting (XSS) protection
- CORS configuration for secure API access

### Audit & Compliance
- Comprehensive audit logging
- User activity tracking
- Compliance reporting
- Data privacy controls (GDPR ready)

## 📚 Documentation & Learning Resources

### APICS Certification Alignment
This project aligns with APICS certification requirements:
- **SCOR Model**: Complete implementation of Plan-Source-Make-Deliver-Return
- **CPIM**: Certified in Production and Inventory Management concepts
- **CSCP**: Certified Supply Chain Professional practices
- **CLTD**: Certified in Logistics, Transportation and Distribution

### Technical Documentation
- API documentation via Swagger/OpenAPI
- User guides and tutorials
- Technical architecture documentation
- Deployment and configuration guides
- Troubleshooting and FAQ

### Training Materials
- Supply chain management best practices
- Platform-specific integration guides
- Performance optimization techniques
- Security implementation guidelines

## 🤝 Contributing

We welcome contributions to improve this supply chain management platform:

1. **Fork the repository**
2. **Create feature branch** (`git checkout -b feature/AmazingFeature`)
3. **Commit changes** (`git commit -m 'Add some AmazingFeature'`)
4. **Push to branch** (`git push origin feature/AmazingFeature`)
5. **Open Pull Request**

### Contribution Guidelines
- Follow APICS best practices and standards
- Maintain code quality and documentation
- Include unit tests for new features
- Update README for significant changes

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🆘 Support & Community

### Getting Help
- **Issues**: Create an issue in the repository for bug reports
- **Discussions**: Join discussions for feature requests and questions
- **Documentation**: Check the comprehensive documentation
- **Community**: Connect with other supply chain professionals

### Professional Services
- Implementation consulting
- Custom integration development
- Training and certification support
- Performance optimization services

## 🔮 Future Enhancements

### Advanced Analytics
- AI-powered predictive analytics and machine learning
- Blockchain integration for supply chain transparency
- IoT device integration for real-time tracking
- Advanced simulation and scenario planning

### Platform Expansion
- Mobile application for on-the-go management
- Voice-enabled interfaces and chatbots
- Augmented reality for warehouse operations
- Digital twin implementation

### Sustainability & ESG
- Carbon footprint tracking and reduction
- Circular economy integration
- Supplier sustainability scoring
- ESG reporting and compliance

### Integration Enhancements
- Expanded ERP system integrations
- Real-time collaboration platforms
- Advanced workflow automation
- Custom connector development

---

**Built with ❤️ using Spring Boot, APICS best practices, and modern web technologies**

*This project demonstrates enterprise-grade supply chain management following APICS SCOR model principles and industry best practices.*


https://reaishma.github.io/Enterprise-supply-chain-management-dashboard-/
