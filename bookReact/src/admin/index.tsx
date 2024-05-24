import {
  Admin,
  Resource,
  ListGuesser,
  fetchUtils,
  ShowGuesser,
  EditGuesser,
} from "react-admin";
import simpleRestProvider from "ra-data-simple-rest";
import { AuthorCreate } from "../components/create/authorCreate";
import { BookCreate } from "../components/create/bookCreate";
import { CategoryCreate } from "../components/create/categoryCreate";
import { BookList } from "../components/ lists/bookList";
import { BookEdit } from "../components/edit/bookEdit";

const dataProvider = simpleRestProvider(
  import.meta.env.VITE_API_URL,
  fetchUtils.fetchJson,
  "X-Total-Count"
);

const App = () => (
  <Admin dataProvider={dataProvider}>
    <Resource
      name="books"
      list={BookList}
      show={ShowGuesser}
      edit={BookEdit}
      create={BookCreate}
    />
    <Resource
      name="authors"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
      create={AuthorCreate}
    />
    <Resource
      name="categories"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
      create={CategoryCreate}
    />
  </Admin>
);

export default App;
