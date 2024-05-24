import {
  Button,
  Create,
  ListButton,
  required,
  SaveButton,
  SimpleForm,
  TextInput,
  Toolbar,
  useCreate,
  useRedirect,
} from "react-admin";



export const AuthorCreate = () => {
  const [create] = useCreate();

  const onCreate = (data: any) => {
    create("authors", { data: [data] });
  };

  const redirect = useRedirect();

  const onSuccess = () => {
    redirect(`/reviews`);
  };

  return (
    <Create mutationOptions={{onSuccess}}>
      <SimpleForm onSubmit={onCreate}>
        <TextInput
          source="first_name"
          validate={[required()]}
          label="First Name"
        />
        <TextInput
          source="last_name"
          validate={[required()]}
          label="Last Name"
        />
      </SimpleForm>
    </Create>
  );
};