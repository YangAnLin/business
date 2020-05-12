import Vue from 'vue'
import { Button, Form, FormItem, Input, Header, Container, Aside, Main } from 'element-ui'
import {
  Message, Menu, Submenu, MenuItemGroup,
  MenuItem, Breadcrumb, BreadcrumbItem, Card,
  Col, Row, Table, TableColumn, Switch, Tooltip, Pagination, Dialog,
  MessageBox, Tag,Timeline,TimelineItem, Tree, Select, Option, Cascader,Upload,Alert,Checkbox,CheckboxGroup,Tabs,TabPane,Step,Steps
} from 'element-ui'

Vue.use(Timeline)
Vue.use(TimelineItem)
Vue.use(Upload)
Vue.use(CheckboxGroup)
Vue.use(Checkbox)
Vue.use(Steps)
Vue.use(Step)
Vue.use(Tabs)
Vue.use(TabPane)
Vue.use(Alert)
Vue.use(Cascader)
Vue.use(Option)
Vue.use(Select)
Vue.use(Tree)
Vue.use(Tag)
Vue.use(Button)
Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Input)
Vue.use(Header)
Vue.use(Input)
Vue.use(Container)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItemGroup)
Vue.use(MenuItem)
Vue.use(Card)
Vue.use(Col)
Vue.use(Row)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Switch)
Vue.use(Tooltip)
Vue.use(Pagination)
Vue.use(Dialog)
Vue.prototype.$message = Message
Vue.prototype.$confirm = MessageBox.confirm

